import subprocess

TESTS = ['PrimsTest', 'KruskalTest', 'DjikstraTest']

try:
    p = subprocess.check_output(['javac', '-version'])
except:
    print('Unable to find java compiler.')
    exit(1)

try:
    p = subprocess.check_output(['javac', 'tools/GraphMaker.java'])
    for test in TESTS:
        print('Compiling %s' % test)
        p = subprocess.check_output(['javac', '%s.java' % test])
except:
    print('Failed to compile java test code.')
    exit(1)

for test in TESTS:
    print('Running %s' % test)
    try:
        p = subprocess.check_output(['java', test])
    except:
        print('Test crashed: %s' % test)
