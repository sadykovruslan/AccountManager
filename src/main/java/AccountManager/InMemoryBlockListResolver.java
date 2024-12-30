package AccountManager;

import java.util.Set;

public class InMemoryBlockListResolver implements BlockListResolver {
    private final Set<Long> blockedAccounts;

    public InMemoryBlockListResolver(Set<Long> blockedAccounts) {
        this.blockedAccounts = blockedAccounts;
    }

    @Override
    public boolean isBlocklisted(long accountId) {
        return blockedAccounts.contains (accountId);
    }
}
