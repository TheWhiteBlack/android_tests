package com.ridery.test.yerih.feature.usertask.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/ridery/test/yerih/core/data/UserRepository;", "(Lcom/ridery/test/yerih/core/data/UserRepository;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addUserTask", "Lkotlinx/coroutines/Job;", "user", "Lcom/ridery/test/yerih/core/domain/UserDomain;", "feature-usertask_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class UserTaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ridery.test.yerih.core.data.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState> uiState = null;
    
    @javax.inject.Inject
    public UserTaskViewModel(@org.jetbrains.annotations.NotNull
    com.ridery.test.yerih.core.data.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job addUserTask(@org.jetbrains.annotations.NotNull
    com.ridery.test.yerih.core.domain.UserDomain user) {
        return null;
    }
}