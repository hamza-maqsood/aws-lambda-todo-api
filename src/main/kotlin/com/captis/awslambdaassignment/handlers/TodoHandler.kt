package com.captis.awslambdaassignment.handlers

import com.captis.awslambdaassignment.AwsLambdaAssignmentApplication
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler


class TodoHandler: SpringBootRequestHandler<String, Any>(AwsLambdaAssignmentApplication::class.java)