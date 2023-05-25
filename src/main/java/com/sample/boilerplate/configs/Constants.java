package com.sample.boilerplate.configs;

import org.springframework.context.annotation.Configuration;

/**
 * Global constant file
 */
@Configuration
public class Constants {
    /**
     * Available user types
     */
   public static enum USER_TYPES {
       INTERNAL,
       INTERN,
       CLIENT,
       CONTRACT
   };
}
