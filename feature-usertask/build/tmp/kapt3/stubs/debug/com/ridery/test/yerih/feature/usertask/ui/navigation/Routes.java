package com.ridery.test.yerih.feature.usertask.ui.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/navigation/Routes;", "", "()V", "graph", "", "home", "signIn", "signup", "Args", "feature-usertask_debug"})
public final class Routes {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String signIn = "main/sign_in";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String signup = "main/sign_up/{user}";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String home = "main/home/{user}";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String graph = "main";
    @org.jetbrains.annotations.NotNull
    public static final com.ridery.test.yerih.feature.usertask.ui.navigation.Routes INSTANCE = null;
    
    private Routes() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/ridery/test/yerih/feature/usertask/ui/navigation/Routes$Args;", "", "()V", "user", "", "feature-usertask_debug"})
    public static final class Args {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String user = "{user}";
        @org.jetbrains.annotations.NotNull
        public static final com.ridery.test.yerih.feature.usertask.ui.navigation.Routes.Args INSTANCE = null;
        
        private Args() {
            super();
        }
    }
}