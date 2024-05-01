# [MNG-8113](https://issues.apache.org/jira/browse/MNG-8113)

Problem: "lets have a Maven Core extension that overrides a Maven Core component"

Steps:
* build/install this project
* uncomment extension in `.mvn/extensions.xml`
* invoke maven again
* you can see that overridden `ClassRealmManager` kicks in, but `ProjectDependenciesResolver` does not 

## How is core component defined?

It seems there are huge differences if Core Component is JSR330 or Plexus (legacy).

The `DefaultProjectDependenciesResolver` in Maven Core (3.9.6) is Plexus component, and
overriding it as this is not possible!

The ONLY way to override it is:
* uncomment plexus annotations
* use/generate plexus/components.xml
* invoke Maven as this: `mvn package -Dmaven.ext.class.path=target/example-0.0.1-SNAPSHOT.jar`
* seems Plexus component overrides via `.mvn/extensions.xml` is not possible?