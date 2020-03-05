package org.somecompany.deploy

import org.somecompany.IStepExecutor
import org.somecompany.ioc.ContextRegistry

/**
 * Example class (without proper implementation) for using the MsBuild tool for building .NET projects.
 */
class Deploy implements Serializable {
    private String _solutionPath

    Deploy(String solutionPath) {
        _solutionPath = solutionPath
    }

    void build() {
        IStepExecutor steps = ContextRegistry.getContext().getStepExecutor()

        int returnStatus = steps.sh("echo \"building ${this._solutionPath}...\"")
        if (returnStatus != 0) {
            steps.error("Some error")
        }
    }
}
