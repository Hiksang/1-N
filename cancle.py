import sys
import os
import datetime
from lib.BootpayApi import BootpayApi

sys.path.append(os.path.join(os.path.dirname(__file__), '..'))
bootpay = BootpayApi('62760dcb2701800021f69ede', '5W90QLfd2L/nYEwGv+V5MqXvcMwp0aoWkIwIO352z5c=')
result = bootpay.get_access_token()

if result['status'] is 200:
    if datetime.time == 14.30:
        print(bootpay.cancel('2000', 'fint', 'refund'))