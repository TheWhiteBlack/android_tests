package com.ridery.test.yerih.feature.usertask.ui;

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
public final class UserTaskViewModel_Factory implements Factory<UserTaskViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  public UserTaskViewModel_Factory(Provider<UserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public UserTaskViewModel get() {
    return newInstance(userRepositoryProvider.get());
  }

  public static UserTaskViewModel_Factory create(Provider<UserRepository> userRepositoryProvider) {
    return new UserTaskViewModel_Factory(userRepositoryProvider);
  }

  public static UserTaskViewModel newInstance(UserRepository userRepository) {
    return new UserTaskViewModel(userRepository);
  }
}
