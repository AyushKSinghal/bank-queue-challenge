package com.bank.abc.domain.entity;

import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PACKAGE, ElementType.TYPE })
@Retention(RetentionPolicy.CLASS)
@Value.Style(
        init = "with*",
        typeAbstract = { "Abstract*" },
        typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC,
        jdkOnly = true)
public @interface ImmutableStyle
{ }
