package com.hillert.coherence.extend.demo.controller;

import com.oracle.coherence.spring.annotation.Name;
import com.oracle.coherence.spring.annotation.SessionName;
import com.oracle.coherence.spring.configuration.NamedCacheConfiguration;
import com.tangosol.net.Coherence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Value("#{" + NamedCacheConfiguration.COHERENCE_CACHE_BEAN_NAME + "}")
@Name
@SessionName
public @interface CM {

	@AliasFor(annotation = Name.class)
	String value() default "";

	@AliasFor(annotation = Name.class, attribute = "value")
	String name() default "";

	@AliasFor(annotation = SessionName.class, attribute = "value")
	String session() default Coherence.DEFAULT_NAME;
}
