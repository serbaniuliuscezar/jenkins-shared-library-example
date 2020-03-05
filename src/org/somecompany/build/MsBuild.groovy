package org.somecompany.build

import org.somecompany.IStepExecutor
import org.somecompany.ioc.ContextRegistry
import com.cloudbees.groovy.cps.NonCPS

/**
 * Example class (without proper implementation) for using the MsBuild tool for building .NET projects.
 */
class MsBuild implements Serializable {
    private String solutionPath

    MsBuild(String solutionPath) {
        this.solutionPath = solutionPath
    }

    IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

    @NonCPS
    void build() {
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.sh("echo \"building ${solutionPath}...\"")
        if (returnStatus != 0) {
            steps.error("Some error")
        }
    }
}
