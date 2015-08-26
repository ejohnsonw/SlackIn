grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
	// configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
	//  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

	// configure settings for the test-app JVM, uses the daemon by default
	test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
	// configure settings for the run-app JVM
	run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
	// configure settings for the run-war JVM
	war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
	// configure settings for the Console UI JVM
	console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
//grails.plugin.location.'generatron-explorer' = "/Users/evolmark/workspaces/ggts/GeneratronExplorer"
grails.project.dependency.resolution = {
	// inherit Grails' default dependencies
	inherits("global") {
		// specify dependency exclusions here; for example, uncomment this to disable ehcache:
		// excludes 'ehcache'
	}
	log "warning" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	checksums true // Whether to verify checksums on resolve
	legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

	repositories {
		inherits true // Whether to inherit repository definitions from plugins

		grailsPlugins()
		grailsHome()
		mavenLocal()
		grailsCentral()
		mavenCentral()
		mavenRepo 'https://raw.github.com/fernandezpablo85/scribe-java/mvn-repo/'
		// uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
		mavenRepo "http://repository.codehaus.org"
		//mavenRepo "http://download.java.net/maven/2/"
		//mavenRepo "http://repository.jboss.com/maven2/"
	}

	dependencies {
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
		// runtime 'mysql:mysql-connector-java:5.1.27'
		// runtime 'org.postgresql:postgresql:9.3-1100-jdbc41'
		runtime 'mysql:mysql-connector-java:5.1.27'
		
		build 'org.apache.commons:commons-lang3:3.1'
		/*compile 'org.apache.httpcomponents:httpcore:4.1.2'
		compile 'org.apache.httpcomponents:httpclient:4.1.2'
		compile 'org.apache.httpcomponents:httpmime:4.2.5'
		runtime 'org.apache.httpcomponents:httpcore:4.1.2'
		runtime 'org.apache.httpcomponents:httpclient:4.1.2'*/
		compile 'org.eclipse.mylyn.github:org.eclipse.egit.github.core:2.0.4'
		compile 'com.stripe:stripe-java:1.32.1'
		//compile 'org.eclipse.jdt:core:3.3.0-v_771'
		/*compile('javax.websocket:javax.websocket-api:1.1') {
			// This line is necessary for deployment to Tomcat, since
			// Tomcat comes with its own version of javax.websocket-api.
			export = false
		}*/

	}

	plugins {
		// plugins for the build system only
		build ":tomcat:7.0.52.1"

		// plugins for the compile step
		compile ":scaffolding:2.0.2"
		compile ':cache:1.1.1'

		// plugins needed at runtime but not for compilation
		runtime ":hibernate:3.6.10.10" // or ":hibernate4:4.3.4"
		//build ":database-migration:1.3.8"
		runtime ":jquery:1.11.0.2"
		runtime ":resources:1.2.7"
		compile ":mail:1.0.6"
		runtime ":cors:1.1.8"
		compile ":rest-client-builder:2.1.1"
 
		
		//runtime ':oauth:2.1.0'
		// Uncomment these (or add new ones) to enable additional resources capabilities
		//runtime ":zipped-resources:1.0.1"
		//runtime ":cached-resources:1.1"
		//runtime ":yui-minify-resources:0.1.5"

		// An alternative to the default resources plugin is the asset-pipeline plugin
		//compile ":asset-pipeline:1.6.1"

		// Uncomment these to enable additional asset-pipeline capabilities
		//compile ":sass-asset-pipeline:1.5.5"
		//compile ":less-asset-pipeline:1.5.3"
		//compile ":coffee-asset-pipeline:1.5.0"
		//compile ":handlebars-asset-pipeline:1.3.0.1"
	}
}