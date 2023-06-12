# Locking notes

1. ReentrantLock : Same thread can lock and apply lock again, but it have to unlock it as many times as it locked it.
2. If the lock os not reentrant then same thread will not be able to relock at all. So it will be blocked forever. (DeadLock).
3. ReentrantLock: Starvation might occur because it doesn't guarantee fairness on locking by defualt. However, it will gaurantee fairness on threads that are waiting for a lock.
4. synchroized block can not span functions or files, while Lock can.
5. synchronized block are always reentrant.
6. Synchronized blocks do not gaurantee fairness. Locks can.
