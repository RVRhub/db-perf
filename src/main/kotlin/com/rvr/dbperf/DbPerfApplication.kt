package com.rvr.dbperf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DbPerfApplication

fun main(args: Array<String>) {
	runApplication<DbPerfApplication>(*args)
}
