package com.gymsystemproject.gymsystem.tenant;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.hibernate.autoconfigure.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

/** Tells Hibernate which gym_id applies to the current session (@TenantId discriminator multi-tenancy). */
@Component
public class GymTenantResolver implements CurrentTenantIdentifierResolver<Long>, HibernatePropertiesCustomizer {

    @Override
    public Long resolveCurrentTenantIdentifier() {
        Long id = TenantContext.get();
        return id != null ? id : TenantContext.NO_TENANT;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }
}
