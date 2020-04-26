# Makefile

.PHONY: all pack clean test doc run profile

all: build

build:
	../gradlew build -q -p ..

#todo
pack:
	../gradlew pack -q

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
	../gradlew profile -q
