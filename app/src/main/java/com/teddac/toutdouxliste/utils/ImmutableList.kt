package com.teddac.toutdouxliste.utils

/**
 * ImmutableList is a delegation of protectedList.
 * As ImmutableList inherite of List, it has only List methods.
 * ImmutableList encapsulates protectedList
 * @see "https://www.baeldung.com/kotlin/mutable-collection-to-immutable"
 */
class ImmutableList<T>(private val protectedList: List<T>): List<T> by protectedList