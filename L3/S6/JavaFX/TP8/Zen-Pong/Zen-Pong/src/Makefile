JVM    = java
JC     = javac
JFLAGS = -Xlint:all -Xdiags:verbose

# List of all .java files
JAVA_SRC=$(shell /usr/bin/find . -name "*.java")

# List of class files to generate
JAVA_BIN=$(JAVA_SRC:.java=.class)

# Default target entry
all: compile_src copy_fxml

# Compile all java files into class files
compile_src: $(JAVA_BIN)

%.class : %.java
	$(JC) -d ../bin $(JFLAGS)  $<

copy_fxml: 
	 find . -name "*.fxml" -exec cp {} ../bin/{} \;

# Remove all unwanted files
##RM_TARGETS=$(shell /usr/bin/find . -name "*.class")
##GET_RMD=$(foreach filename, $(RM_TARGETS), '$(filename)')

clean:
	@rm -rf ../bin/*
#	@$(RM) $(GET_RMD)

.PHONY: doc
doc:
	@echo " > Generating javadoc ..."
	@javadoc -d ./doc  $(JAVA_SRC)

