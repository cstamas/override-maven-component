package org.acme.example;

import org.apache.maven.project.DependencyResolutionException;
import org.apache.maven.project.DependencyResolutionRequest;
import org.apache.maven.project.DependencyResolutionResult;
import org.apache.maven.project.ProjectDependenciesResolver;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.eclipse.sisu.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Example of Plexus Core component: overriding it is not simple.
 */
@Singleton
@Named
@Priority(10)
// @Component(role = ProjectDependenciesResolver.class, hint = "default")
public class DefaultProjectDependenciesResolver implements ProjectDependenciesResolver {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Requirement
    private org.apache.maven.project.DefaultProjectDependenciesResolver delegate;

    @Override
    public DependencyResolutionResult resolve(DependencyResolutionRequest dependencyResolutionRequest) throws DependencyResolutionException {
        logger.info("ACME I am resolving!");
        return delegate.resolve(dependencyResolutionRequest);
    }
}
