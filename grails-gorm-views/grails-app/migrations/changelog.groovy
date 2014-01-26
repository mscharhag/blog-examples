databaseChangeLog = {

	changeSet(author: "Michael Scharhag (generated)", id: "1389809337189-1") {
		createTable(tableName: "address") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "city", type: "VARCHAR(255)")

			column(name: "country", type: "VARCHAR(255)")

			column(name: "postal_code", type: "VARCHAR(255)")

			column(name: "street", type: "VARCHAR(255)")
		}
	}

	changeSet(author: "Michael Scharhag (generated)", id: "1389809337189-2") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "Michael Scharhag (generated)", id: "1389809337189-3") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "user", constraintName: "FK36EBCB10060251", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: 'Michael Scharhag', id: '1389809337189-4') {
		createView("""
				SELECT u.id, u.name, a.country
				FROM user u
				JOIN address a on u.address_id = a.id
			""", viewName: 'user_with_country')
	}
}