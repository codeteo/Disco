package com.disco.man.discogman.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Dagger scope for Activities.
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}