package annotations;

import java.lang.annotation.Documented;

@Documented
public @interface Unused {
	
	String message() default "This method has been replaced. Implement unused methods only where necessary.";

}
