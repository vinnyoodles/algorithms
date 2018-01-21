import subprocess, os

TESTS = ['PrimTest', 'KruskalTest', 'DijkstraTest', 'PriorityQueueTest']
DATASTRUCTURES = ['PriorityQueue']
ALGORITHMS = ['PrimMST', 'KruskalMST', 'DijkstraPathFinder']
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
    dependencies = ['tools/GraphMaker.java']
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
    print('Running %s' % test, end=': ')
    try:
        subprocess.run(['java', '-cp', BIN_DIR, test])
        print(u'\u2713')
    except:
        print('Test crashed: %s' % test)
