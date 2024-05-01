package org.acme.example;

import org.apache.maven.project.DependencyResolutionException;
import org.apache.maven.project.DependencyResolutionRequest;
import org.apache.maven.project.DependencyResolutionResult;
import org.apache.maven.project.ProjectDependenciesResolver;
import org.eclipse.sisu.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Example of Plexus Core component: overriding it is not simple.
 */
@Singleton
@Named
@Priority(10)
public class DefaultProjectDependenciesResolver implements ProjectDependenciesResolver {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    public DefaultProjectDependenciesResolver() {
        logger.info("ACME-RESOLVER Created!");
    }

    @Override
    public DependencyResolutionResult resolve(DependencyResolutionRequest dependencyResolutionRequest) throws DependencyResolutionException {
        logger.info("ACME-RESOLVER I am resolving!");
        throw new RuntimeException("boom");
    }
}
