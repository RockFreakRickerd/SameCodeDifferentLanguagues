class Vak:
    # Constructor waar moduleCode en jaargegeven meegegeven moet worden
    def __init__(self, moduleCode, jaargegeven):
        self.cijfers = []
        self.moduleCode = moduleCode
        if jaargegeven > 0:
            if jaargegeven > 5:
                print("Vak "+moduleCode+" staat een te hoog jaar bij")
                jaargegeven = 5
            self.jaar = jaargegeven
        else:
            print("getal moet groter zijn dan 0")
            return

    # Set nieuwe cijfer
    def setCijfers(self, cijfer):
        self.cijfers.append(cijfer)

    # Get data van deze vak
    def getModuleCode(self):
        return self.moduleCode

    def getCijfers(self):
        return self.cijfers

    def getJaar(self):
        return self.jaar

    # Print alle info van Vak
    def printInfo(self):
        print("Module code: "+self.moduleCode)
        print("Gegeven jaar: "+str(self.jaar))
