from mpp.models import SQLConcurrencyTestCase
from mpp.models import SQLTestCase

class PxfColumnNameMismatch(SQLConcurrencyTestCase):
    """
    @product_version  gpdb: [1.3.1-]
    @db_name pxfautomation
    @concurrency 1
    @gpdiff True
    """
    sql_dir = 'sql'
    ans_dir = 'expected'
    out_dir = 'output'
