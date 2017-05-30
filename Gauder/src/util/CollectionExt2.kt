package org.jetbrains.dekaf.util


fun<O> Iterable<O>.selectOne(fortune: Double): O {
    return this.toList().selectOne(fortune)
}

fun<O> List<O>.selectOne(fortune: Double): O {
    val n = this.size
    if (n == 0) throw IllegalStateException("Cannot select one element form an empty collection")
    if (n == 1) return this.first()
    var index: Int = Math.min((fortune * n.toDouble()).toInt(), n-1)
    assert(index >= 0)
    assert(index < n)
    return this[index]
}
