import os
import argparse
import re
import operator

parser = argparse.ArgumentParser(description='CsvCreator')
parser.add_argument("source", help="data source")
parser.add_argument("target", help="csv dir for writing")


def ReadPath(src):
    txtList = list()
    flacList = list()
    paths = os.listdir(src)
    for path in paths:
        pathAbs = os.path.join(src, path)
        if os.path.isdir(pathAbs):
            tl, fl = ReadPath(pathAbs)
            txtList = txtList + tl
            flacList = flacList + fl
        elif os.path.isfile(pathAbs):
            if re.match("\\d+-\\d+\.trans-\\d+\.txt", path):
                for p in paths:
                    if(re.match("\\d+-\\d+-\\d+\.flac", p) and PathEq(path,p)):
						txtList.append(pathAbs)
                        flacList.append(os.path.join(src,p))
                        break
    return txtList, flacList


def PathEq(txtPath, flacPath):
    txtPath = txtPath[0:-15] + txtPath[-9:-4]
    if (operator.eq(txtPath, flacPath[0:-5])):
        return True
    else:
        return False


# def ReSort(txtList, flacList):
#     flacListReSort = list()
#     i = 0
#     while (i < len(txtList)):
#         if (PathEq(txtList[i], flacList[i]) == False):
#             # print("not eq")
#             j = 0;
#             while (j < len(flacList)):
#                 if (PathEq(txtList[i], flacList[j])):
#                     break
#                 j = j + 1;
#             flacListReSort.append(flacList[j])
#         else:
#             flacListReSort.append(flacList[i])
#         i = i + 1;
#     return flacListReSort


def WriteCsv(target, txtList, flacList):
    f = open(target, "w")
    i = 0;
    while (i < len(txtList)):
        f.write(txtList[i])
        f.write(",")
        f.write(flacList[i])
        f.write("\n")
        i = i + 1;
    f.close()


if __name__ == '__main__':
    args = parser.parse_args()
    txtList, flacList = ReadPath(args.source)
    WriteCsv(args.target, txtList, flacList)
