import sys
import os
sys.path.append(os.path.join(os.path.dirname(__file__), '..'))
from lib.BootpayApi import BootpayApi

bootpay = BootpayApi('62760dcb2701800021f69ede', '5W90QLfd2L/nYEwGv+V5MqXvcMwp0aoWkIwIO352z5c=')
result = bootpay.get_access_token()
print(result['data']['token'])