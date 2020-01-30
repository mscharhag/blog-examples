package com.example.demo;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.slf4j.Logger;
import javax.persistence.EntityManager;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

@AnalyzeClasses(packages = "com.example.demo")
public class ArchUnitTest {

    // verify that classes whose name name ends with "Service" should be located in a "service" package
    @ArchTest
    private final ArchRule services_are_located_in_service_package = classes()
            .that().haveSimpleNameEndingWith("Service")
            .should().resideInAPackage("..service");


    // verify that logger fields are private, static and final
    @ArchTest
    private final ArchRule loggers_should_be_private_static_final = fields()
            .that().haveRawType(Logger.class)
                    .should().bePrivate()
                    .andShould().beStatic()
                    .andShould().beFinal();

    // verify that interfaces are not located in implementation packages
    @ArchTest
    static final ArchRule interfaces_should_not_be_placed_in_impl_packages = noClasses()
            .that().resideInAPackage("..impl..")
                    .should().beInterfaces();

    // methods in classes whose name ends with "Util" should be static
    @ArchTest
    static final ArchRule utility_methods_should_be_static = methods()
            .that().areDeclaredInClassesThat().haveSimpleNameEndingWith("Util")
                    .should().beStatic();


    @ArchTest
    static final ArchRule only_repositories_should_use_entityManager = noClasses()
            .that().resideOutsideOfPackage("..repository")
            .should().dependOnClassesThat().areAssignableTo(EntityManager.class);

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

            .layer("Controllers").definedBy("com.example.demo.layers.controller..")
            .layer("Services").definedBy("com.example.demo.layers.service..")
            .layer("Repositories").definedBy("com.example.demo.layers.repository..")

            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Services");


    @ArchTest
    private final ArchRule no_generic_exceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

}
