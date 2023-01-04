import apriltag
import cv2
img = cv2.imread('apriltag_view2.jpg'.cv2.IMREAD_GRAYSCALE)
detector = apriltag.Detector()
result = detector.detect(img)