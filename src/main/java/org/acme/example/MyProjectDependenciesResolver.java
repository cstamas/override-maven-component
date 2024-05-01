package org.acme.example;

import org.apache.maven.project.DependencyResolutionException;
import org.apache.maven.project.DependencyResolutionRequest;
import org.apache.maven.project.DependencyResolutionResult;
import org.apache.maven.project.ProjectDependenciesResolver;
import org.eclipse.aether.RepositorySystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.requireNonNull;

public class MyProjectDependenciesResolver implements ProjectDependenciesResolver {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final RepositorySystem repositorySystem;

    public MyProjectDependenciesResolver(RepositorySystem repositorySystem) {
        this.repositorySystem = requireNonNull(repositorySystem);
        logger.info("I am created!");
    }

    @Override
    public DependencyResolutionResult resolve(DependencyResolutionRequest dependencyResolutionRequest) throws DependencyResolutionException {
        logger.info("I am resolving!");
        throw new RuntimeException("just crash");
    }
}
