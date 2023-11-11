package com.ridery.test.yerih.feature.usertask.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/viewmodels/SignUpViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/ridery/test/yerih/core/data/UserRepository;", "(Lcom/ridery/test/yerih/core/data/UserRepository;)V", "user", "Lcom/ridery/test/yerih/core/domain/UserDomain;", "getUser", "()Lcom/ridery/test/yerih/core/domain/UserDomain;", "setUser", "(Lcom/ridery/test/yerih/core/domain/UserDomain;)V", "saveUser", "Lkotlinx/coroutines/Job;", "feature-usertask_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SignUpViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ridery.test.yerih.core.data.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private com.ridery.test.yerih.core.domain.UserDomain user;
    
    @javax.inject.Inject
    public SignUpViewModel(@org.jetbrains.annotations.NotNull
    com.ridery.test.yerih.core.data.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ridery.test.yerih.core.domain.UserDomain getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull
    com.ridery.test.yerih.core.domain.UserDomain p0) {
    }
    
    private final kotlinx.coroutines.Job saveUser(com.ridery.test.yerih.core.domain.UserDomain user) {
        return null;
    }
}