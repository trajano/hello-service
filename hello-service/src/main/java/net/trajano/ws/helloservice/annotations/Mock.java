package net.trajano.ws.helloservice.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Mock {

}
