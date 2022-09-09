package com.example.spring_boot_training.annotation;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('TODO_DELETE')")
public interface HasTodoDeleteRights {
}
