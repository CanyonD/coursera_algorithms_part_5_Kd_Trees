"# coursera_algorithms_part_5_Kd_Trees" 99/100

See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Findbugs:     PASSED
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 3 warnings)

Correctness:  35/36 tests passed
Memory:       16/16 tests passed
Timing:       42/42 tests passed

Aggregate score: 98.33%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
7.8K Apr  1 19:28 KdTree.java
2.2K Apr  1 19:28 PointSET.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac PointSET.java
*-----------------------------------------------------------

% javac KdTree.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
PointSET:

KdTree:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------


================================================================


% pmd .
*-----------------------------------------------------------
KdTree.java:19: Instance (and static) variables should be declared at the top of the class, before any method declarations, constructors, or nested classes. [FieldDeclarationsShouldBeAtStartOfClass]
PMD ends with 1 warning.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] PointSET.java:32:12: 'for' is not followed by whitespace. [WhitespaceAfter]
Checkstyle ends with 0 errors and 1 warning.

% custom checkstyle checks for PointSET.java
*-----------------------------------------------------------

% custom checkstyle checks for KdTree.java
*-----------------------------------------------------------
[WARN] KdTree.java:134:9: You should not need to use the 'SET' data type in this program. [IllegalType]
[WARN] KdTree.java:139:52: You should not need to use the 'SET' data type in this program. [IllegalType]
Checkstyle ends with 0 errors and 2 warnings.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of PointSET
*-----------------------------------------------------------
Running 8 total tests.

A point in an m-by-m grid means that it is of the form (i/m, j/m),
where i and j are integers between 0 and m

Test 1: inserting n random points and check size() after each insertion
        (size may be less than n because of duplicates)
  * 100000 random points in a 65536-by-65536 grid
  * 100000 random points in a 8192-by-8192 grid
  * 100000 random points in a 1024-by-1024 grid
  * 100000 random points in a 128-by-128 grid
  * 100000 random points in a 16-by-16 grid
==> passed

Test 2: check isEmpty() for n = 0, 1, and 2 points
  * 0 points
  * 1 point
  * 2 points
==> passed

Test 3: insert n random points and check contains() for n random query points
  * 100000 random points in a 65536-by-65536 grid
  * 100000 random points in a 8192-by-8192 grid
  * 100000 random points in a 1024-by-1024 grid
  * 100000 random points in a 128-by-128 grid
  * 100000 random points in a 16-by-16 grid
==> passed

Test 4: insert n random points and check nearest() for n random query points
  * 1000 random points in a 65536-by-65536 grid
  * 1000 random points in a 8192-by-8192 grid
  * 1000 random points in a 1024-by-1024 grid
  * 1000 random points in a 128-by-128 grid
  * 1000 random points in a 16-by-16 grid
==> passed

Test 5: insert n random points and check range() for n random query rectangles
  * 1000 random rectangles and points in a 65536-by-65536 grid
  * 1000 random rectangles and points in a 8192-by-8192 grid
  * 1000 random rectangles and points in a 1024-by-1024 grid
  * 1000 random rectangles and points in a 128-by-128 grid
  * 1000 random rectangles and points in a 16-by-16 grid
==> passed

Test 6: check intermixed sequence of calls to isEmpty(), size(),
        insert(), contains(), range(), and nearest() with probabilities
        p1, p2, p3, p4, p5, and p6, respectively
  * 10000 calls with random points in a 8192-by-8192 grid
    and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
  * 10000 calls with random points in a 1024-by-1024 grid
    and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
  * 10000 calls with random points in a 128-by-128 grid
    and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
  * 10000 calls with random points in a 16-by-16 grid
    and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
  * 10000 calls with random points in a 1-by-1 grid
    and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
==> passed

Test 7: check intermixed sequence of calls to isEmpty(), size(),
        insert(), contains(), range(), and nearest() with probabilities
        p1, p2, p3=0, p4, p5, and p6, respectively
        (data structure with 0 points)
  * 1000 calls with random points in a 1024-by-1024 grid
    and probabilities 0.5, 0.5, 0.0, 0.0, 0.0, 0.0
  * 1000 calls with random points in a 1024-by-1024 grid
    and probabilities 0.2, 0.2, 0.0, 0.6, 0.0, 0.0
  * 1000 calls with random points in a 1024-by-1024 grid
    and probabilities 0.2, 0.2, 0.0, 0.0, 0.6, 0.0
  * 1000 calls with random points in a 1024-by-1024 grid
    and probabilities 0.2, 0.2, 0.0, 0.0, 0.0, 0.6
  * 1000 calls with random points in a 1024-by-1024 grid
    and probabilities 0.2, 0.2, 0.0, 0.2, 0.2, 0.2
==> passed

Test 8: check whether two PointSET objects can be created at the same time
==> passed


Total: 8/8 tests passed!


================================================================
Testing correctness of KdTree
*-----------------------------------------------------------
Running 28 total tests.

In the tests below, we consider three classes of points and rectangles.

  * Non-degenerate points: no two points (or rectangles) share either an
                           x-coordinate or a y-coordinate

  * Distinct points:       no two points (or rectangles) share both an
                           x-coordinate and a y-coordinate

  * General points:        no restrictions on the x-coordinates or y-coordinates
                           of the points (or rectangles)

A point in an m-by-m grid means that it is of the form (i/m, j/m),
where i and j are integers between 0 and m (inclusive).

Test 1a: insert points from file; check size() and isEmpty() after each insertion
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
==> passed

Test 1b: insert non-degenerate points; check size() and isEmpty() after each insertion
  * 1 random non-degenerate points in a 1-by-1 grid
  * 5 random non-degenerate points in a 8-by-8 grid
  * 10 random non-degenerate points in a 16-by-16 grid
  * 50 random non-degenerate points in a 128-by-128 grid
  * 500 random non-degenerate points in a 1024-by-1024 grid
  * 50000 random non-degenerate points in a 65536-by-65536 grid
==> passed

Test 1c: insert distinct points; check size() and isEmpty() after each insertion
  * 1 random distinct points in a 1-by-1 grid
  * 10 random distinct points in a 8-by-8 grid
  * 20 random distinct points in a 16-by-16 grid
  * 10000 random distinct points in a 128-by-128 grid
  * 100000 random distinct points in a 1024-by-1024 grid
  * 100000 random distinct points in a 65536-by-65536 grid
==> passed

Test 1d: insert general points; check size() and isEmpty() after each insertion
  * 5 random general points in a 1-by-1 grid
  * 10 random general points in a 4-by-4 grid
  * 50 random general points in a 8-by-8 grid
  * 100000 random general points in a 16-by-16 grid
  * 100000 random general points in a 128-by-128 grid
  * 100000 random general points in a 1024-by-1024 grid
==> passed

Test 2a: insert points from file; check contains() with random query points
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
==> passed

Test 2b: insert non-degenerate points; check contains() with random query points
  * 1 random non-degenerate points in a 1-by-1 grid
  * 5 random non-degenerate points in a 8-by-8 grid
  * 10 random non-degenerate points in a 16-by-16 grid
  * 20 random non-degenerate points in a 32-by-32 grid
  * 500 random non-degenerate points in a 1024-by-1024 grid
  * 10000 random non-degenerate points in a 65536-by-65536 grid
==> passed

Test 2c: insert distinct points; check contains() with random query points
  * 1 random distinct points in a 1-by-1 grid
  * 10 random distinct points in a 4-by-4 grid
  * 20 random distinct points in a 8-by-8 grid
  * 10000 random distinct points in a 128-by-128 grid
  * 100000 random distinct points in a 1024-by-1024 grid
  * 100000 random distinct points in a 65536-by-65536 grid
==> passed

Test 2d: insert general points; check contains() with random query points
  * 10000 random general points in a 1-by-1 grid
  * 10000 random general points in a 16-by-16 grid
  * 10000 random general points in a 128-by-128 grid
  * 10000 random general points in a 1024-by-1024 grid
==> passed

Test 3a: insert points from file; check range() with random query rectangles
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
==> passed

Test 3b: insert non-degenerate points; check range() with random query rectangles
  * 1 random non-degenerate points and random rectangles in a 2-by-2 grid
  * 5 random non-degenerate points and random rectangles in a 8-by-8 grid
  * 10 random non-degenerate points and random rectangles in a 16-by-16 grid
  * 20 random non-degenerate points and random rectangles in a 32-by-32 grid
  * 500 random non-degenerate points and random rectangles in a 1024-by-1024 grid
  * 10000 random non-degenerate points and random rectangles in a 65536-by-65536 grid
==> passed

Test 3c: insert distinct points; check range() with random query rectangles
  * 2 random distinct points and random rectangles in a 2-by-2 grid
  * 10 random distinct points and random rectangles in a 4-by-4 grid
  * 20 random distinct points and random rectangles in a 8-by-8 grid
  * 100 random distinct points and random rectangles in a 16-by-16 grid
  * 1000 random distinct points and random rectangles in a 64-by-64 grid
  * 10000 random distinct points and random rectangles in a 128-by-128 grid
==> passed

Test 3d: insert general points; check range() with random query rectangles
  * 5000 random general points and random rectangles in a 2-by-2 grid
  * 5000 random general points and random rectangles in a 16-by-16 grid
  * 5000 random general points and random rectangles in a 128-by-128 grid
  * 5000 random general points and random rectangles in a 1024-by-1024 grid
==> passed

Test 3e: insert random points; check range() with tiny rectangles
         enclosing each point
  * 5 tiny rectangles and 5 general points in a 2-by-2 grid
  * 10 tiny rectangles and 10 general points in a 4-by-4 grid
  * 20 tiny rectangles and 20 general points in a 8-by-8 grid
  * 5000 tiny rectangles and 5000 general points in a 128-by-128 grid
  * 5000 tiny rectangles and 5000 general points in a 1024-by-1024 grid
  * 5000 tiny rectangles and 5000 general points in a 65536-by-65536 grid
==> passed

Test 4a: insert points from file; check range() with random query rectangles
         and check traversal of kd-tree
  * input5.txt
  * input10.txt
==> passed

Test 4b: insert non-degenerate points; check range() with random query rectangles
         and check traversal of kd-tree
  * 3 random non-degenerate points and 1000 random rectangles in a 4-by-4 grid
  * 6 random non-degenerate points and 1000 random rectangles in a 8-by-8 grid
  * 10 random non-degenerate points and 1000 random rectangles in a 16-by-16 grid
  * 20 random non-degenerate points and 1000 random rectangles in a 32-by-32 grid
  * 30 random non-degenerate points and 1000 random rectangles in a 64-by-64 grid
==> passed

Test 5a: insert points from file; check nearest() with random query points
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
==> passed

Test 5b: insert non-degenerate points; check nearest() with random query points
  * 5 random non-degenerate points in a 8-by-8 grid
  * 10 random non-degenerate points in a 16-by-16 grid
  * 20 random non-degenerate points in a 32-by-32 grid
  * 30 random non-degenerate points in a 64-by-64 grid
  * 10000 random non-degenerate points in a 65536-by-65536 grid
==> passed

Test 5c: insert distinct points; check nearest() with random query points
  * 10 random distinct points in a 4-by-4 grid
  * 15 random distinct points in a 8-by-8 grid
  * 20 random distinct points in a 16-by-16 grid
  * 100 random distinct points in a 32-by-32 grid
  * 10000 random distinct points in a 65536-by-65536 grid
==> passed

Test 5d: insert general points; check nearest() with random query points
  * 10000 random general points in a 16-by-16 grid
  * 10000 random general points in a 128-by-128 grid
  * 10000 random general points in a 1024-by-1024 grid
==> passed

Test 6a: insert points from file; check nearest() with random query points
         and check traversal of kd-tree
  * input5.txt
    - failed on trial 4 of 1000
    - performs incorrect traversal of kd-tree during call to nearest()
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6
    - query point                   = (0.7, 0.13)
    - student   nearest()           = (0.7, 0.2)
    - reference nearest()           = (0.7, 0.2)
    - student   distanceSquaredTo() = 0.0049
    - reference distanceSquaredTo() = 0.0049
    - student sequence of kd-tree nodes involved in calls to distanceSquaredTo():
      A B C E 
    - reference sequence of kd-tree nodes involved in calls to distanceSquaredTo():
      A E B C 

  * input10.txt
==> FAILED

Test 6b: insert non-degenerate points; check nearest() with random query points
         and check traversal of kd-tree
  * 5 random non-degenerate points in a 8-by-8 grid
  * 10 random non-degenerate points in a 16-by-16 grid
  * 20 random non-degenerate points in a 32-by-32 grid
  * 30 random non-degenerate points in a 64-by-64 grid
  * 50 random non-degenerate points in a 128-by-128 grid
  * 1000 random non-degenerate points in a 2048-by-2048 grid
==> passed

Test 7: insert n random points; check that repeated calls to get(),
         range(), and nearest() with the same argument yield same results
  * 10 random general points in a 4-by-4 grid
  * 20 random general points in a 8-by-8 grid
  * 100 random general points in a 128-by-128 grid
  * 1000 random general points in a 65536-by-65536 grid
==> passed

Test 8a: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with non-degenerate points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with non-degenerate points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with non-degenerate points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with non-degenerate points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with non-degenerate points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with non-degenerate points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
==> passed

Test 8b: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with distinct points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with distinct points in a 10-by-10 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with distinct points in a 100-by-100 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with distinct points in a 1000-by-1000 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with distinct points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with distinct points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
==> passed

Test 8c: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with general points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with general points in a 10-by-10 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with general points in a 100-by-100 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with general points in a 1000-by-1000 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with general points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with general points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
==> passed

Test 9: check intermixed sequence of calls to insert(), isEmpty(),
        size(), contains(), range(), and nearest() with probabilities
        (p1=0, p2, p3, p4, p5, p6), respectively
        (data structure with 0 points)
  * 1000 calls with no points in a 1024-by-1024 grid
    and probabilities (0.0, 0.5, 0.5, 0.0, 0.0, 0.0)
  * 1000 calls with no points in a 1024-by-1024 grid
    and probabilities (0.0, 0.2, 0.2, 0.6, 0.0, 0.0)
  * 1000 calls with no points in a 1024-by-1024 grid
    and probabilities (0.0, 0.2, 0.2, 0.0, 0.6, 0.0)
  * 1000 calls with no points in a 1024-by-1024 grid
    and probabilities (0.0, 0.2, 0.2, 0.0, 0.0, 0.6)
  * 1000 calls with no points in a 1024-by-1024 grid
    and probabilities (0.0, 0.2, 0.2, 0.2, 0.2, 0.2)
==> passed

Test 10: check that two KdTree objects can be created at the same time
==> passed

Test 11: check that the specified exception is thrown with null arguments
  * argument to insert() is null
  * argument to contains() is null
  * argument to range() is null
  * argument to nearest() is null
==> passed


Total: 27/28 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point2D
*-----------------------------------------------------------
Memory of Point2D object = 32 bytes
================================================================



Analyzing memory of RectHV
*-----------------------------------------------------------
Memory of RectHV object = 48 bytes
================================================================



Analyzing memory of PointSET
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a PointSET with n points (including Point2D and RectHV objects).
Maximum allowed memory is 96n + 200 bytes.

                 n       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          264                264
=> passed        2          360                360
=> passed        5          648                648
=> passed       10         1128               1128
=> passed       25         2568               2568
=> passed      100         9768               9768
=> passed      400        38568              38568
=> passed      800        76968              76968
==> 8/8 tests passed

Total: 8/8 tests passed!

Estimated student   memory (bytes) = 96.00 n + 168.00  (R^2 = 1.000)
Estimated reference memory (bytes) = 96.00 n + 168.00  (R^2 = 1.000)
================================================================



Analyzing memory of KdTree
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a KdTree with n points (including Point2D and RectHV objects).
Maximum allowed memory is 312n + 192 bytes.

                 n       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          160                160
=> passed        2          288                288
=> passed        5          672                672
=> passed       10         1312               1312
=> passed       25         3232               3232
=> passed      100        12832              12832
=> passed      400        51232              51232
=> passed      800       102432             102432
==> 8/8 tests passed

Total: 8/8 tests passed!

Estimated student   memory (bytes) = 128.00 n + 32.00  (R^2 = 1.000)
Estimated reference memory (bytes) = 128.00 n + 32.00  (R^2 = 1.000)
================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing PointSET
*-----------------------------------------------------------
Running 14 total tests.


Inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed   160000     941180         
=> passed   320000    1017736         
=> passed   640000     833073         
=> passed  1280000     825601         
==> 4/4 tests passed

Performing contains() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed   160000     353649         
=> passed   320000     343727         
=> passed   640000     284124         
=> passed  1280000     344248         
==> 4/4 tests passed

Performing range() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed    10000       3662         
=> passed    20000       1767         
=> passed    40000        732         
==> 3/3 tests passed

Performing nearest() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed    10000       4529         
=> passed    20000       2079         
=> passed    40000        830         
==> 3/3 tests passed

Total: 14/14 tests passed!


================================================================



Timing KdTree
*-----------------------------------------------------------
Running 28 total tests.


Test 1a-d: Insert n points into a 2d tree. The table gives the average number of calls
           to methods in RectHV and Point per call to insert().

                                                                                                Point2D
               n      ops per second       RectHV()           x()               y()             equals()
----------------------------------------------------------------------------------------------------------------
=> passed   160000     863105               1.0              23.6              22.6              22.6         
=> passed   320000     891958               1.0              24.0              23.0              23.0         
=> passed   640000     715298               1.0              25.5              24.5              24.5         
=> passed  1280000     597691               1.0              27.6              26.6              26.6         
==> 4/4 tests passed


Test 2a-h: Perform contains() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to contains().

                                                                               Point2D
               n      ops per second       x()               y()               equals()
-----------------------------------------------------------------------------------------------
=> passed    10000     405195              18.5              17.5              18.0         
=> passed    20000     427490              19.7              18.7              19.2         
=> passed    40000     386689              21.8              20.8              21.3         
=> passed    80000     392146              22.0              21.0              21.5         
=> passed   160000     336719              23.2              22.2              22.7         
=> passed   320000     318322              25.0              24.0              24.5         
=> passed   640000     281428              25.7              24.7              25.2         
=> passed  1280000     241621              27.2              26.2              26.7         
==> 8/8 tests passed


Test 3a-h: Perform range() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to range().

               n      ops per second       intersects()      contains()        x()               y()
---------------------------------------------------------------------------------------------------------------
=> passed    10000     264222              49.4              31.1              50.1              12.1         
=> passed    20000     249338              51.7              32.6              53.3              16.2         
=> passed    40000     220453              63.9              39.3              63.1              14.1         
=> passed    80000     192189              66.1              40.7              65.2              14.9         
=> passed   160000     177424              69.0              42.5              70.9              20.4         
=> passed   320000     175383              66.0              40.2              65.2              15.7         
=> passed   640000     129985              71.0              43.3              70.7              19.2         
=> passed  1280000     117226              77.7              47.0              74.8              14.2         
==> 8/8 tests passed


Test 4a-h: Perform nearest() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to nearest().

                                         Point2D                 RectHV
               n      ops per second     distanceSquaredTo()     distanceSquaredTo()        x()               y()
------------------------------------------------------------------------------------------------------------------------
=> passed    10000   309565                  69.0                   19.4                    69.6              68.8         
=> passed    20000   305489                  75.9                   21.6                    76.7              76.1         
=> passed    40000   268680                  89.4                   25.6                    91.7              89.9         
=> passed    80000   255279                  91.3                   26.3                    92.5              92.5         
=> passed   160000   221126                  99.2                   28.7                   101.5             101.1         
=> passed   320000   196019                 103.5                   30.1                   106.3             104.8         
=> passed   640000   139208                 107.4                   31.2                   109.6             108.9         
=> passed  1280000   122866                 120.3                   35.2                   122.9             122.2         
==> 8/8 tests passed



Total: 28/28 tests passed!


================================================================