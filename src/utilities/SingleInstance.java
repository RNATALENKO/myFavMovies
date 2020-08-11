package utilities;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

//https://stackoverflow.com/questions/10508846/how-to-make-sure-that-only-a-single-instance-of-a-java-application-is-running/20015771#20015771

//this class will make sure the program is running as a single instance
public class SingleInstance {
	
	static File file; 
	static FileChannel fileChannel;
	static FileLock lock;
	public static boolean running = false; 
	
	
	public boolean instanceExists() throws IOException {
		
		//create instance of a file with lock extension, path should be in file where executeable is kept
		file = new File("client.lock");
		
		/*
		//if file with pathname doesn't exist, create it, and set boolean to true; 
		 * this piece of code was causing the executeable to open gui on second click, bug fixed
		if(!file.exists()) {
			file.createNewFile();
			running = true; 	
		}
		
		//if it does exist then delete the file
		else {
			file.delete();
		}
		*/
		
		//random access file creates a stream to read from  and to write to, to a file with specified name
		@SuppressWarnings("resource")
		FileChannel channel = new RandomAccessFile(file,"rw").getChannel(); 
		
		//trylock() gets an exclusive lock on the channel's file
		lock = channel.tryLock();
		
		//if the lock is null, close channel, return true, which means instance exists
		//Note a null return on trylock() means another program holds an overlapping lock
		if(lock == null) {
			channel.close();
			return true; 
		}
		
		//get the runtime object associated with current Java application, add a shutdown hook thread
		ShutdownHook hook = new ShutdownHook(); 
		Runtime.getRuntime().addShutdownHook(hook);
		
		return running; 
	}
	

	public static void unlockFile() throws IOException {
		
		//if lock is valid, release lock
		if(lock!=null) {
			lock.release();
			fileChannel.close();
		}
		
		file.delete();
		running = false; 	
	}
	
	static class ShutdownHook extends Thread {
		
		public void run() {
			try {
				unlockFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
