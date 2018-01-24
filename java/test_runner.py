import subprocess, os, sys

TESTS = ['MSTTest', 'DijkstraTest', 'PriorityQueueTest', 'SkipListTest']
DATASTRUCTURES = ['PriorityQueue', 'GraphNode', 'GraphEdge', 'SkipList']
ALGORITHMS = ['PrimMST', 'KruskalMST', 'DijkstraPathFinder']
DEPENDENCIES = ['GraphMaker', 'Utilities']
BIN_DIR = 'bin'

try:
    subprocess.check_output(['javac', '-version'])
except:
    print('Unable to find java compiler')
    exit(1)

# Make a bin directory to store Java class files.
if not os.path.isdir('bin'):
    os.makedirs('bin')

try:
    dependencies = list(map((lambda name: 'tools/%s.java' % name), DEPENDENCIES))
    datastructures = list(map((lambda name: 'datastructures/%s.java' % name), DATASTRUCTURES))
    algorithms = list(map((lambda name: 'algorithms/%s.java' % name), ALGORITHMS))
    tests = list(map((lambda name: 'tests/%s.java' % name), TESTS))
    files = dependencies + datastructures + algorithms + tests
    print('Compiling the following files:\n\t%s\n' % '\n\t'.join(files))
    subprocess.check_output(['javac', '-d', BIN_DIR] + files)

except:
    print('Failed to compile java test code')
    exit(1)

for test in TESTS:
    print('Running %s:' % test)
    sys.stdout.flush()
    try:
        subprocess.run(['java', '-cp', BIN_DIR, test])
    except:
        print('Test crashed: %s' % test)
