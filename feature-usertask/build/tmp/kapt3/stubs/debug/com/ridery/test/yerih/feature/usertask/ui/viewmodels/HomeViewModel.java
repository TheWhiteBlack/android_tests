package com.ridery.test.yerih.feature.usertask.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/viewmodels/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/ridery/test/yerih/core/data/UserRepository;", "(Lcom/ridery/test/yerih/core/data/UserRepository;)V", "_event", "Lkotlinx/coroutines/channels/Channel;", "Lcom/ridery/test/yerih/feature/usertask/ui/viewmodels/HomeViewModel$UiEvent;", "event", "Lkotlinx/coroutines/flow/Flow;", "getEvent", "()Lkotlinx/coroutines/flow/Flow;", "user", "", "getUser", "()Ljava/lang/String;", "setUser", "(Ljava/lang/String;)V", "UiEvent", "feature-usertask_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ridery.test.yerih.core.data.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String user = "";
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.channels.Channel<com.ridery.test.yerih.feature.usertask.ui.viewmodels.HomeViewModel.UiEvent> _event = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ridery.test.yerih.feature.usertask.ui.viewmodels.HomeViewModel.UiEvent> event = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.ridery.test.yerih.core.data.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ridery.test.yerih.feature.usertask.ui.viewmodels.HomeViewModel.UiEvent> getEvent() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/viewmodels/HomeViewModel$UiEvent;", "", "ToastMsg", "Lcom/ridery/test/yerih/feature/usertask/ui/viewmodels/HomeViewModel$UiEvent$ToastMsg;", "feature-usertask_debug"})
    public static abstract interface UiEvent {
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/viewmodels/HomeViewModel$UiEvent$ToastMsg;", "Lcom/ridery/test/yerih/feature/usertask/ui/viewmodels/HomeViewModel$UiEvent;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-usertask_debug"})
        public static final class ToastMsg implements com.ridery.test.yerih.feature.usertask.ui.viewmodels.HomeViewModel.UiEvent {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String msg = null;
            
            public ToastMsg(@org.jetbrains.annotations.NotNull
            java.lang.String msg) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getMsg() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.ridery.test.yerih.feature.usertask.ui.viewmodels.HomeViewModel.UiEvent.ToastMsg copy(@org.jetbrains.annotations.NotNull
            java.lang.String msg) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override
            @org.jetbrains.annotations.NotNull
            public java.lang.String toString() {
                return null;
            }
        }
    }
}