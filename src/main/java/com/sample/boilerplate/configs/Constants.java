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
    }

    /**
     * Available data status types
     */
    public static enum DATA_STATUS_TYPES {
        ACTIVE,
        INACTIVE,
        DELETED
    }

    /**
     * Available projects types
     */
    public static enum PROJECT_TYPES {
        CLIENT,
        INTERNAL,
        PRODUCT,
        PRE_SALE,
    }

    /**
     * Available Project billing Types for client
     */
    public static enum PROJECT_BILLING_TYPES {
        RETAINER,
        FIXED_BID,
        SUPPORT_AND_MAINTENANCE,
        STAFF_AUGMENTATION,
        TIME_AND_MATERIAL,
    }
}
