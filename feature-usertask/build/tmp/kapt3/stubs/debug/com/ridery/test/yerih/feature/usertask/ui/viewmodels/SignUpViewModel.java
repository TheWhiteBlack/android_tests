package com.ridery.test.yerih.feature.usertask.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/viewmodels/SignUpViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/ridery/test/yerih/core/data/UserRepository;", "(Lcom/ridery/test/yerih/core/data/UserRepository;)V", "saveUser", "Lkotlinx/coroutines/Job;", "user", "Lcom/ridery/test/yerih/core/domain/UserDomain;", "feature-usertask_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SignUpViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ridery.test.yerih.core.data.UserRepository userRepository = null;
    
    @javax.inject.Inject
    public SignUpViewModel(@org.jetbrains.annotations.NotNull
    com.ridery.test.yerih.core.data.UserRepository userRepository) {
        super();
    }
    
    private final kotlinx.coroutines.Job saveUser(com.ridery.test.yerih.core.domain.UserDomain user) {
        return null;
    }
}