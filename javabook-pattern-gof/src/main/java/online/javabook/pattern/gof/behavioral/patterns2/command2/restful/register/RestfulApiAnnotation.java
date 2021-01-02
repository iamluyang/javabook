package online.javabook.pattern.gof.behavioral.patterns2.command2.restful.register;

import online.javabook.pattern.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;

public @interface RestfulApiAnnotation {

	String path();
	
	HttpMethod httpMethod();

}
