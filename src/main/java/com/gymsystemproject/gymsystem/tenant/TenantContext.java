package com.gymsystemproject.gymsystem.tenant;

/** Holds the gym (tenant) id of the current request. Set it in a filter, always clear it in finally. */
public final class TenantContext {

    /** Matches no real gym: tenant-scoped queries return nothing, inserts fail. Fail-closed on purpose. */
    public static final Long NO_TENANT = 0L;

    private static final ThreadLocal<Long> CURRENT = new ThreadLocal<>();

    private TenantContext() {}

    public static void set(Long gymId) { CURRENT.set(gymId); }

    public static Long get() { return CURRENT.get(); }

    public static void clear() { CURRENT.remove(); }
}
