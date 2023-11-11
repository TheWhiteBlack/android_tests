package com.ridery.test.yerih.feature.usertask.ui.viewmodels;

import com.ridery.test.yerih.core.data.UserRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<String> userProvider;

  public HomeViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<String> userProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.userProvider = userProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(userRepositoryProvider.get(), userProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<String> userProvider) {
    return new HomeViewModel_Factory(userRepositoryProvider, userProvider);
  }

  public static HomeViewModel newInstance(UserRepository userRepository, String user) {
    return new HomeViewModel(userRepository, user);
  }
}
