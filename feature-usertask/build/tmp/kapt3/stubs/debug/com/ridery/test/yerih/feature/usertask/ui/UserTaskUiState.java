package com.ridery.test.yerih.feature.usertask.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState;", "", "Error", "Loading", "Success", "Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState$Error;", "Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState$Loading;", "Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState$Success;", "feature-usertask_debug"})
public abstract interface UserTaskUiState {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState$Error;", "Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-usertask_debug"})
    public static final class Error implements com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState {
        @org.jetbrains.annotations.NotNull
        private final java.lang.Throwable throwable = null;
        
        public Error(@org.jetbrains.annotations.NotNull
        java.lang.Throwable throwable) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.Throwable getThrowable() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.Throwable component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState.Error copy(@org.jetbrains.annotations.NotNull
        java.lang.Throwable throwable) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState$Loading;", "Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState;", "()V", "feature-usertask_debug"})
    public static final class Loading implements com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState {
        @org.jetbrains.annotations.NotNull
        public static final com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState.Loading INSTANCE = null;
        
        private Loading() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState$Success;", "Lcom/ridery/test/yerih/feature/usertask/ui/UserTaskUiState;", "data", "", "", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-usertask_debug"})
    public static final class Success implements com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState {
        @org.jetbrains.annotations.NotNull
        private final java.util.List<java.lang.String> data = null;
        
        public Success(@org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> data) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> getData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.String> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ridery.test.yerih.feature.usertask.ui.UserTaskUiState.Success copy(@org.jetbrains.annotations.NotNull
        java.util.List<java.lang.String> data) {
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