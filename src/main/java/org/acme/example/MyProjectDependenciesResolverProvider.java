package org.acme.example;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import org.apache.maven.lifecycle.internal.ProjectArtifactFactory;
import org.apache.maven.project.ProjectDependenciesResolver;
import org.eclipse.aether.RepositorySystem;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

public class MyProjectDependenciesResolverProvider implements Provider<ProjectDependenciesResolver> {
    @Named
    public static class Module extends AbstractModule {
        @Override
        protected void configure() {
            bind(ProjectArtifactFactory.class).toProvider(TypeLiteral.get(MyProjectDependenciesResolverProvider.class));
        }
    }

    private final MyProjectDependenciesResolver projectDependenciesResolver;

    @Inject
    public MyProjectDependenciesResolverProvider(RepositorySystem repositorySystem) {
        this.projectDependenciesResolver = new MyProjectDependenciesResolver(repositorySystem);
    }

    @Override
    public ProjectDependenciesResolver get() {
        return projectDependenciesResolver;
    }
}
