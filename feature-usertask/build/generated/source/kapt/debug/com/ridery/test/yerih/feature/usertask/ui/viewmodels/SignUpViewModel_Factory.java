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
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  public SignUpViewModel_Factory(Provider<UserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(userRepositoryProvider.get());
  }

  public static SignUpViewModel_Factory create(Provider<UserRepository> userRepositoryProvider) {
    return new SignUpViewModel_Factory(userRepositoryProvider);
  }

  public static SignUpViewModel newInstance(UserRepository userRepository) {
    return new SignUpViewModel(userRepository);
  }
}
