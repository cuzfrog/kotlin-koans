package iii_conventions

import util.TODO


class Invokable {
    private var invokeTimes = 0
    operator fun invoke(): Invokable {
        invokeTimes++
        return this
    }

    fun getNumberOfInvocations(): Int = invokeTimes
}

fun todoTask31(): Nothing = TODO(
        """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
        references = *arrayOf({ invokable: Invokable -> }))

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
