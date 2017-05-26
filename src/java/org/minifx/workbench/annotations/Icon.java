/**
 * Copyright (c) 2016 European Organisation for Nuclear Research (CERN), All Rights Reserved.
 */

package org.minifx.workbench.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.minifx.workbench.domain.Perspective;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.paint.Color;

/**
 * Annotation for specifying the Icon of a MiniFx view or {@link Perspective}. NOTE: the {@link #color()} String must
 * conform to the rules of JavaFX {@link Color#valueOf(String)} method.
 * 
 * @author acalia
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Icon {

    FontAwesomeIcon value();

    String color() default "#38678e";

}
