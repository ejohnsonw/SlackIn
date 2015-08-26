dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"

	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 1800000
		timeBetweenEvictionRunsMillis = 1800000
		maxWait = 10000
		validationQuery="select 1 as dbcp_connection_test"
		testOnBorrow=true
		testOnReturn=true
		testWhileIdle=true
	}
}

/*dataSource_TempDB {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	url = "jdbc:mysql://localhost:3307/TempDB?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
	dbCreate = "update" // one of 'create', 'create-drop','update'
	username = "root"
	password = "twelve12"
	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 1800000
		timeBetweenEvictionRunsMillis = 1800000
		maxWait = 10000
	}
}*/


dataSource_Slackin {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	url = "jdbc:mysql://localhost:3306/Slackin?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
	dbCreate = "update" // one of 'create', 'create-drop','update'
	username = "root"
	password = "twelve12"
	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 1800000
		timeBetweenEvictionRunsMillis = 1800000
		maxWait = 10000
		validationQuery="select 1 as dbcp_connection_test"
		testOnBorrow=true
		testOnReturn=true
		testWhileIdle=true
	}
}
dataSource_Account {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
	url = "jdbc:mysql://localhost:3306/Slackin?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
	dbCreate = "update" // one of 'create', 'create-drop','update'
	username = "root"
	password = "twelve12"
	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 1800000
		timeBetweenEvictionRunsMillis = 1800000
		maxWait = 10000
		validationQuery="select 1 as dbcp_connection_test"
		testOnBorrow=true
		testOnReturn=true
		testWhileIdle=true
	}
}
hibernate {
	cache.use_second_level_cache = false
	cache.use_query_cache = false
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "update" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost:3306/Slackin2?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			username = "root"
			password = "twelve12"
		}

		dataSource_Slackin {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
			url = "jdbc:mysql://localhost:3306/Slackin?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			dbCreate = "update" // one of 'create', 'create-drop','update'
			username = "root"
			password = "twelve12"
			properties {
				maxActive = 50
				maxIdle = 25
				minIdle = 5
				initialSize = 5
				minEvictableIdleTimeMillis = 1800000
				timeBetweenEvictionRunsMillis = 1800000
				maxWait = 10000
				validationQuery="select 1 as dbcp_connection_test"
				testOnBorrow=true
				testOnReturn=true
				testWhileIdle=true
			}
		}
		dataSource_Account {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
			url = "jdbc:mysql://localhost:3306/Slackin?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			dbCreate = "update" // one of 'create', 'create-drop','update'
			username = "root"
			password = "twelve12"
			properties {
				maxActive = 50
				maxIdle = 25
				minIdle = 5
				initialSize = 5
				minEvictableIdleTimeMillis = 1800000
				timeBetweenEvictionRunsMillis = 1800000
				maxWait = 10000
				validationQuery="select 1 as dbcp_connection_test"
				testOnBorrow=true
				testOnReturn=true
				testWhileIdle=true
			}
		}
		hibernate { show_sql = false }
	}
	test {
		dataSource_Slackin {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost:3306/SlackinTest?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			username = "root"
			password = "twelve12"
			properties {
				maxActive = 50
				maxIdle = 25
				minIdle = 5
				initialSize = 5
				minEvictableIdleTimeMillis = 1800000
				timeBetweenEvictionRunsMillis = 1800000
				maxWait = 10000
				validationQuery="select 1 as dbcp_connection_test"
				testOnBorrow=true
				testOnReturn=true
				testWhileIdle=true
			}
		}
		
		dataSource_TempDB {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
			url = "jdbc:mysql://localhost:3307/TempDBTest?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			dbCreate = "update" // one of 'create', 'create-drop','update'
			username = "root"
			password = "twelve12"
			properties {
				maxActive = 50
				maxIdle = 25
				minIdle = 5
				initialSize = 5
				minEvictableIdleTimeMillis = 1800000
				timeBetweenEvictionRunsMillis = 1800000
				maxWait = 10000
				validationQuery="select 1 as dbcp_connection_test"
				testOnBorrow=true
				testOnReturn=true
				testWhileIdle=true
			}
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/Slackin2?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			username = "root"
			password = "twelve12"
		}
		
		dataSource_Slackin {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
			url = "jdbc:mysql://localhost:3306/Slackin?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			dbCreate = "update" // one of 'create', 'create-drop','update'
			username = "root"
			password = "twelve12"
			properties {
				maxActive = 50
				maxIdle = 25
				minIdle = 5
				initialSize = 5
				minEvictableIdleTimeMillis = 1800000
				timeBetweenEvictionRunsMillis = 1800000
				maxWait = 10000
				validationQuery="select 1 as dbcp_connection_test"
				testOnBorrow=true
				testOnReturn=true
				testWhileIdle=true
			}
		}
		dataSource_Account {
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
			url = "jdbc:mysql://localhost:3306/Slackin?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
			dbCreate = "update" // one of 'create', 'create-drop','update'
			username = "root"
			password = "twelve12"
			properties {
				maxActive = 50
				maxIdle = 25
				minIdle = 5
				initialSize = 5
				minEvictableIdleTimeMillis = 1800000
				timeBetweenEvictionRunsMillis = 1800000
				maxWait = 10000
				validationQuery="select 1 as dbcp_connection_test"
				testOnBorrow=true
				testOnReturn=true
				testWhileIdle=true
			}
		}
	}
}
