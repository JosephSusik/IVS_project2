# Makefile

.PHONY: all pack clean test doc run profile

all: build

build:
	../gradlew build -q -p ..

pack: doc
	../gradlew pack -q -p ..

clean:
	../gradlew clean -q -p ..

test:
	../gradlew test -q -p ..

doc:
	../gradlew doxygen -q -p ..

run: all
	../gradlew run -q -p ..

#todo
profile:
	../gradlew profile -q -p ..
