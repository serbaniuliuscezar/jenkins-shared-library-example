import org.somecompany.build.MsBuild
import org.somecompany.ioc.ContextRegistry

/**
 * Example custom step for easy use of MsBuild inside Jenkinsfiles
 * @param solutionPath Path to .sln file
 * @return
 */
def call() {
    ContextRegistry.registerDefaultContext(this)
    String solutionPath = 'test'
    def msbuilder = new MsBuild(solutionPath)
    msbuilder.build()
}
